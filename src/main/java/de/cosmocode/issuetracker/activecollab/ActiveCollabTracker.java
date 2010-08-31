package de.cosmocode.issuetracker.activecollab;

import de.cosmocode.issuetracker.Issue;
import de.cosmocode.issuetracker.IssueTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tobias Sarnowski
 */
final class ActiveCollabTracker implements IssueTracker {
    private static final Logger LOG = LoggerFactory.getLogger(ActiveCollabTracker.class);

    @Override
    public Issue createIssue(String title, String description) {
        return null;
    }
}