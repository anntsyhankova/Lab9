package tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import entity.Ad;
import entity.AdList;
import entity.User;
import helper.AdListHelper;

public class DeleteAllAd extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        String errorMessage = null;
        AdList adList = (AdList) getJspContext().getAttribute("ads", PageContext.APPLICATION_SCOPE);
        User currentUser = (User) getJspContext().getAttribute("authUser", PageContext.SESSION_SCOPE);

        if (errorMessage == null) {
            for (Ad advertisment : adList.getAds()) {
                if (currentUser == null || (advertisment.getId() > 0 && advertisment.getAuthorId() != currentUser.getId())) {
                    errorMessage = "Вы пытаетесь изменить сообщение, к которому не обладаете правами доступа!";
                }else
                    adList.deleteAd(advertisment);
            }
            AdListHelper.saveAdList(adList);
        }
        getJspContext().setAttribute("errorMessage", errorMessage, PageContext.SESSION_SCOPE);
    }
}
