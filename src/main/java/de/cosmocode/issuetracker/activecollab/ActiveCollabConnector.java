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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * Static access point for {@link ActiveCollab}.
 * 
 * Based on:
 * http://www.activecollab.com/docs/manuals/developers/api/tickets
 *
 * @author Tobias Sarnowski
 */
public final class ActiveCollabConnector {
    
    private ActiveCollabConnector() {
        
    }

    /**
     * Connects to an ActiveCollab server.
     *
     * @since 1.0
     * @param uri the uri to connect to
     * @param token the api token
     * @param projectId the project identifier
     * @return an {@link ActiveCollab} instance
     */
    public static ActiveCollab connectActiveCollab(URI uri, String token, int projectId) {
        Preconditions.checkNotNull(uri, "URI");
        Preconditions.checkNotNull(token, "Token");
        return new DefaultActiveCollab(uri, token, projectId);
    }

}
