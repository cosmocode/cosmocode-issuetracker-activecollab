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

import de.cosmocode.issuetracker.IssueTracker;

import java.net.URI;

/**
 * Describes an active collab implementation of {@link IssueTracker}
 *
 * @author Tobias Sarnowski
 */
public interface ActiveCollab extends IssueTracker {

    /**
     * Symbolizes that an ID is not set
     */
    public static final int NO_ID = -1;


    /**
     * ActiveCollab's home URI
     *
     * @return the used uri
     */
    URI getUri();

    /**
     * ActiveCollab's user
     *
     * @return the used user
     */
    String getUser();

    /**
     * ActiveCollab's project ID
     *
     * @return the user project id
     */
    int getProjectId();

    /**
     * The ticket's milestone. Used to create tickets in.
     *
     * @return the project's milestone ID or {@link ActiveCollab#NO_ID}
     */
    int getMilestoneId();

    /**
     * Sets the milestone ID
     *
     * @param milestoneId the project's milestone ID
     */
    void setMilestoneId(int milestoneId);

    /**
     * The ticket's parent ID. Used to create tickets in.
     * Parent ID can be a category, ticket or task.
     *
     * @return the project's parent ID or {@link ActiveCollab#NO_ID}
     */
    int getParentId();

    /**
     * Sets the parent ID
     *
     * @param parentId the project's parent ID
     */
    void setParentId(int parentId);

}
