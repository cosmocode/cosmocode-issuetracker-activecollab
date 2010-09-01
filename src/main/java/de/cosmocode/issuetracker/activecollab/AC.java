/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.issuetracker.activecollab;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import de.cosmocode.issuetracker.AbstractIssueTracker;
import de.cosmocode.issuetracker.Issue;
import de.cosmocode.issuetracker.IssueTrackerException;
import de.cosmocode.issuetracker.StoringIssueFailed;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Tobias Sarnowski
 */
final class AC extends AbstractIssueTracker implements ActiveCollab {
    private static final Logger LOG = LoggerFactory.getLogger(AC.class);

    private final URI uri;
    private final URI apiUri;
    private final String token;
    private final int projectId;
    private int milestoneId = ActiveCollab.NO_ID;
    private int parentId = ActiveCollab.NO_ID;

    private final HttpClient httpclient;
    private final ObjectMapper mapper = new ObjectMapper();

    AC(URI uri, String token, int projectId) {
        this.uri = uri;
        this.token = token;
        this.projectId = projectId;

        // add path to api.php to the given URI
        String url = uri.toString();
        if (!url.endsWith("/")) {
            url = url + "/";
        }
        url = url + "public/api.php";
        try {
            this.apiUri = new URI(url);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }

        // initialize the http clients
        httpclient = new DefaultHttpClient();
    }

    @Override
    public URI getUri() {
        return uri;
    }

    @Override
    public int getProjectId() {
        return projectId;
    }

    @Override
    public int getMilestoneId() {
        return milestoneId;
    }

    @Override
    public void setMilestoneId(int milestoneId) {
        this.milestoneId = milestoneId;
    }

    @Override
    public int getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public ActiveCollabIssue createIssue(String title, String description) throws IssueTrackerException {
        final String pathInfo = "";
        final Map<String,String> parameters = Maps.newHashMap();

        try {
            return parseTicket(requestPost(pathInfo, parameters));
        } catch (IOException e) {
            throw new StoringIssueFailed(e);
        }
    }

    @Override
    public Iterable<ActiveCollabIssue> listIssues() throws IssueTrackerException {
        final String pathInfo = "";
        final Map<String,String> parameters = Maps.newHashMap();

        try {
            return parseTickets(requestPost(pathInfo, parameters));
        } catch (IOException e) {
            throw new StoringIssueFailed(e);
        }
    }

    @Override
    public ActiveCollabIssue updateIssue(Issue issue) throws IssueTrackerException {
        final String pathInfo = "";
        final Map<String,String> parameters = Maps.newHashMap();

        try {
            return parseTicket(requestPost(pathInfo, parameters));
        } catch (IOException e) {
            throw new StoringIssueFailed(e);
        }
    }

    @Override
    public String toString() {
        return "AC{" +
                "uri=" + uri +
                ", projectId=" + projectId +
                '}';
    }

    private JsonNode requestGet(String pathInfo) throws IOException {
        HttpGet get = new HttpGet();
        return request(get, pathInfo);
    }

    private JsonNode requestPost(String pathInfo, Map<String,String> parameters) throws IOException {
        HttpPost post = new HttpPost();

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(parameters.size() + 1);
        nameValuePairs.add(new BasicNameValuePair("submitted", "submitted"));
        for (Map.Entry<String,String> entry: parameters.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        return request(post, pathInfo);
    }

    private JsonNode request(HttpRequestBase request, String pathInfo) throws IOException {
        final URI uri;
        try {
            uri = new URI(apiUri.toString() + "?token=" + token + "&path_info=" + pathInfo);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
        request.setURI(uri);

        request.setHeader("Accept", "application/json");

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String response = httpclient.execute(request, responseHandler);

        return mapper.readValue(response, JsonNode.class);
    }

    private List<ActiveCollabIssue> parseTickets(JsonNode json) {
        List<ActiveCollabIssue> issues = Lists.newArrayList();
        json.toString();
        return issues;
    }

    private ActiveCollabIssue parseTicket(JsonNode json) {
        return null;
    }

}