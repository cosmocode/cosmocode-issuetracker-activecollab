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

import de.cosmocode.issuetracker.Issue;

/**
 * An extended {@link Issue} which provides additional
 * information specific to ActiveCollab.
 * 
 * @author Tobias Sarnowski
 */
public interface ActiveCollabIssue extends Issue {

    /**
     * Provides the visibility of this issue.
     *
     * @return the visibility
     */
    int getVisibility();

    /**
     * Changes the visibility of this issue.
     *
     * @param visibility the new visibility
     */
    void setVisibility(int visibility);

    /**
     * Provides the milestone id of this issue.
     *
     * @return the milestone id
     */
    int getMilestoneId();

    /**
     * Changes the milestone id of this issue.
     *
     * @param milestoneId the new milestone id
     */
    void setMilestoneId(int milestoneId);

    /**
     * Provides the parent id of this issue.
     *
     * @return the parent id
     */
    int getParentId();

    /**
     * Changes the parent id of this issue.
     *
     * @param parentId the new parent id
     */
    void setParentId(int parentId);

}
