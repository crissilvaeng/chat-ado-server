package com.edu.infnet.chat.command;

import com.edu.infnet.chat.storage.Storage;

public interface Command {

	public String execute(Storage storage);
}
