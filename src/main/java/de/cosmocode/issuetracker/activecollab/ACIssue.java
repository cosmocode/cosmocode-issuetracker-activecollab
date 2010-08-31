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
import de.cosmocode.issuetracker.IssueTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tobias Sarnowski
 */
final class ACIssue implements ActiveCollabIssue {
    private static final Logger LOG = LoggerFactory.getLogger(ACIssue.class);

    private final AC ac;
    private final String id;
    private final String title;
    private final String description;

    ACIssue(AC ac, String id, String title, String description) {
        this.ac = ac;
        this.id = id;
        this.title = title;
        this.description = description;
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
    public String toString() {
        return "ACIssue{" +
                "ac=" + ac +
                ", id='" + id + '\'' +
                '}';
    }
}