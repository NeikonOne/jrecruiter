package org.jrecruiter.web.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jrecruiter.model.User;
import org.jrecruiter.web.interceptor.StoreMessages;
import org.texturemedia.smarturls.Result;

/**
 * Resets the users passwords and emails it back to the user.
 *
 * @author Gunnar Hillert
 * @version $Id:UserService.java 128 2007-07-27 03:55:54Z ghillert $
 */
@Result(name="success", location="login", type="redirectAction")
public class GetPasswordAction extends BaseAction {

    private User user;

    /** serialVersionUID. */
    private static final long serialVersionUID = -3422780336408883930L;

    private final Log LOG = LogFactory.getLog(GetPasswordAction.class);

    public String execute() {
        return INPUT;
    }

    @StoreMessages
    public String process() {

        this.user = userService.getUser(this.user.getUsername());

        userService.resetPassword(this.user);

        super.addActionMessage("An email has been sent to " + user.getEmail());
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}