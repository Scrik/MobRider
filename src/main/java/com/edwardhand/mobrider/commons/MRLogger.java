package com.edwardhand.mobrider.commons;

import java.util.logging.Logger;

public class MRLogger
{
    private static final String LOG_NAME = "MobRider";
    private static MRLogger instance = new MRLogger();

    private Logger logger;
    private String name;

    private MRLogger()
    {
        logger = Logger.getLogger("Minecraft");
        name = LOG_NAME;
    }

    public static MRLogger getInstance()
    {
        return instance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void info(String msg)
    {
        logger.info(format(msg));
    }

    public void warning(String msg)
    {
        logger.warning(format(msg));
    }

    public void severe(String msg)
    {
        logger.severe(format(msg));
    }

    public void debug(String msg)
    {
        logger.info("DEBUG: " + msg);
    }

    public String format(String msg)
    {
        return String.format("[%s] %s", name, msg);
    }
}
