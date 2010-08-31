package de.cosmocode.issuetracker.activecollab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * Based on:
 * http://www.activecollab.com/docs/manuals/developers/api/tickets
 *
 * @author Tobias Sarnowski
 */
public final class ActiveCollab {
    private static final Logger LOG = LoggerFactory.getLogger(ActiveCollab.class);

    public static ActiveCollabTracker connectActiveCollab(URI uri) {
        ActiveCollabTracker ac = new ActiveCollabTracker();
        return ac;
    }

}