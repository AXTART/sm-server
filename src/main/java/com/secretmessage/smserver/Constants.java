package com.secretmessage.smserver;

import com.secretmessage.smserver.database.SmDatabase;
import com.secretmessage.smserver.database.SmDatabaseTestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

    public static SmDatabase DATABASE = new SmDatabaseTestImpl();
    public static Logger LOGGER = LoggerFactory.getLogger(SmServerApplication.class);

}
