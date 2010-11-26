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

import org.codehaus.jackson.JsonNode;

import de.cosmocode.issuetracker.IssueTracker;
import de.cosmocode.issuetracker.IssueTrackerException;

/**
 * Default {@link ActiveCollabIssue} implementation.
 * 
 * @author Tobias Sarnowski
 */
final class DefaultActiveCollabIssue implements ActiveCollabIssue {

    private final DefaultActiveCollab ac;
    private String id;
    private String title;
    private String description;
    private int visibility;
    private int milestoneId;
    private int parentId;

    DefaultActiveCollabIssue(DefaultActiveCollab ac, JsonNode json) {
        this.ac = ac;
        this.id = Integer.toString(json.get("id").getIntValue());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public IssueTracker getIssueTracker() {
        return ac;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update() throws IssueTrackerException {
        ac.updateIssue(this);
    }

    @Override
    public int getVisibility() {
        return visibility;
    }

    @Override
    public void setVisibility(int visibility) {
        this.visibility = visibility;
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
    public String toString() {
        return "ActiveCollabIssue [ac=" + ac + ", id=" + id + "]";
    }
    
}
