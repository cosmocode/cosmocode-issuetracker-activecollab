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

import java.net.URI;

import com.google.common.base.Predicate;

import de.cosmocode.issuetracker.Issue;
import de.cosmocode.issuetracker.IssueTracker;
import de.cosmocode.issuetracker.IssueTrackerException;

/**
 * Describes an active collab implementation of {@link IssueTracker}.
 *
 * @author Tobias Sarnowski
 */
public interface ActiveCollab extends IssueTracker {

    /**
     * Symbolizes that an ID is not set.
     */
    int NOT_SET = -1;


    /**
     * ActiveCollab's home URI.
     *
     * @return the used uri
     */
    URI getUri();

    /**
     * ActiveCollab's project ID.
     *
     * @return the user project id
     */
    int getProjectId();

    /**
     * The new ticket's visibility.
     *
     * @return the visibility or {@link ActiveCollab#NOT_SET}
     */
    int getVisibility();

    /**
     * Sets the visibility for new tickets.
     *
     * @param visibility the visibility for new tickets
     */
    void setVisibility(int visibility);

    /**
     * The ticket's milestone. Used to create tickets in.
     *
     * @return the project's milestone ID or {@link ActiveCollab#NOT_SET}
     */
    int getMilestoneId();

    /**
     * Sets the milestone ID.
     *
     * @param milestoneId the project's milestone ID
     */
    void setMilestoneId(int milestoneId);

    /**
     * The ticket's parent ID. Used to create tickets in.
     * Parent ID can be a category, ticket or task.
     *
     * @return the project's parent ID or {@link ActiveCollab#NOT_SET}
     */
    int getParentId();

    /**
     * Sets the parent ID.
     *
     * @param parentId the project's parent ID
     */
    void setParentId(int parentId);

    /**
     * We officially support ActiveCollabIssues.
     *
     * @param title the issue's title
     * @param description the issue's description
     * @return an ActiveCollabIssue
     * @throws IssueTrackerException if something goes wrong
     */
    @Override
    ActiveCollabIssue createIssue(String title, String description) throws IssueTrackerException;

    /**
     * We officially support ActiveCollabIssues.
     *
     * @param title the issue's title
     * @param description the issue's description
     * @param duplicationCheck the predicate which checks for duplicates
     * @return an ActiveCollabIssue
     * @throws IssueTrackerException if something goes wrong
     */
    @Override
    ActiveCollabIssue createIssue(String title, String description, Predicate<? super Issue> duplicationCheck)
        throws IssueTrackerException;

    /**
     * We officially support ActiveCollabIssues.
     *
     * @return a list of ActiveCollabIssue
     * @throws IssueTrackerException if something goes wrong
     */
    @Override
    Iterable<ActiveCollabIssue> listIssues() throws IssueTrackerException;

    /**
     * Lets you update a ticket, you have to use the result afterwards.
     *
     * @param issue an ActiveCollabIssue
     * @return an ActiveCollabIssue
     * @throws IssueTrackerException if something goes wrong
     */
    ActiveCollabIssue updateIssue(ActiveCollabIssue issue) throws IssueTrackerException;
}
