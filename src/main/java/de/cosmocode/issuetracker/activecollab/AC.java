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

import de.cosmocode.issuetracker.AbstractIssueTracker;
import de.cosmocode.issuetracker.Issue;
import de.cosmocode.issuetracker.IssueTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;

/**
 * @author Tobias Sarnowski
 */
final class AC extends AbstractIssueTracker implements ActiveCollab {
    private static final Logger LOG = LoggerFactory.getLogger(AC.class);

    private final URI uri;
    private final String user;
    private final String apiKey;
    private final int projectId;
    private int milestoneId = ActiveCollab.NO_ID;
    private int parentId = ActiveCollab.NO_ID;

    AC(URI uri, String user, String apiKey, int projectId) {
        this.uri = uri;
        this.user = user;
        this.apiKey = apiKey;
        this.projectId = projectId;
    }

    @Override
    public URI getUri() {
        return uri;
    }

    @Override
    public String getUser() {
        return user;
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
    public Issue createIssue(String title, String description) {
        return null;
    }

    @Override
    public List<Issue> listIssues() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateIssue(Issue issue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "AC{" +
                "uri=" + uri +
                ", user='" + user + '\'' +
                ", projectId=" + projectId +
                '}';
    }

}