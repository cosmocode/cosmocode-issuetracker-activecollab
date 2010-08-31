package de.cosmocode.issuetracker.activecollab;

import de.cosmocode.issuetracker.Issue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tobias Sarnowski
 */
final class ActiveCollabIssue implements Issue {
    private static final Logger LOG = LoggerFactory.getLogger(ActiveCollabIssue.class);

    private final String id;
    private final String title;
    private final String description;

    ActiveCollabIssue(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String getId() {
        return id;
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
}