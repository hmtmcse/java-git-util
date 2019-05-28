package com.hmtmcse.gitutil.base;

import com.hmtmcse.shellutil.base.CmdOutputLineCallBack;

public class GitRequest {

    public String appPath = null;
    public String repositoryPath = null;
    public Boolean isPrintInConsole = false;
    public Boolean isPrintCommands = false;
    public CmdOutputLineCallBack cmdOutputLineCallBack = null;

    public GitRequest setAppPath(String appPath) {
        this.appPath = appPath;
        return this;
    }

    public GitRequest setRepositoryPath(String repositoryPath) {
        this.repositoryPath = repositoryPath;
        return this;
    }

    public GitRequest setPrintInConsole(Boolean printInConsole) {
        isPrintInConsole = printInConsole;
        return this;
    }

    public GitRequest setPrintCommands(Boolean printCommands) {
        isPrintCommands = printCommands;
        return this;
    }

    public static GitRequest instance(String appPath, String repositoryPath){
        return new GitRequest().setAppPath(appPath).setRepositoryPath(repositoryPath);
    }

}
