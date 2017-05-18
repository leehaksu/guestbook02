package com.jx372.guestbook.action;

import com.jx372.web.action.Action;
import com.jx372.web.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;

		if ("add".equals(actionName)) {
			action = new addAction();
		} else if ("deleteform".equals(actionName)) {
			action = new deleformAction();

		} else if ("delete".equals(actionName)) {
			action = new deleteAction();

		} else {
			action = new ListAction();

		}

		return action;
	}

}
