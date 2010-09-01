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

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * Based on:
 * http://www.activecollab.com/docs/manuals/developers/api/tickets
 *
 * @author Tobias Sarnowski
 */
public final class ActiveCollabConnector {
    private static final Logger LOG = LoggerFactory.getLogger(ActiveCollabConnector.class);

    public static ActiveCollab connectActiveCollab(URI uri, String token, int projectId) {
        Preconditions.checkNotNull(uri, "URI");
        Preconditions.checkNotNull(token, "Token");
        return new AC(uri, token, projectId);
    }

}