package com.hmtmcse.gitutil.base;

import com.hmtmcse.shellutil.base.CommandRequest;
import com.hmtmcse.shellutil.base.CommandResponse;
import com.hmtmcse.shellutil.base.OSCommandExec;

import java.io.File;

public class GitCommand {

    private GitRequest gitRequest;


    public GitCommand(GitRequest gitRequest) throws GitCommandException {
        this.gitRequest = gitRequest;
        validateRequestData();
    }

    private void validateRequestData() throws GitCommandException {
        if (gitRequest.appPath == null){
            throw new GitCommandException("Please Specify Git Executable Path");
        }else if (gitRequest.repositoryPath == null){
            throw new GitCommandException("Please Specify Repository Path");
        }
        File file = new File(gitRequest.appPath);
        if (!file.exists()){
            throw new GitCommandException("Invalid Git Executable Path");
        }

        file = new File(gitRequest.repositoryPath);
        if (!file.exists()){
            throw new GitCommandException("Invalid Repository Path");
        }
    }


    private CommandResponse execute(String ...command) throws GitCommandException {
        OSCommandExec osCommandExec = new OSCommandExec();
        CommandRequest commandRequest = CommandRequest.withCommand(command);
        commandRequest.setCommandHome(gitRequest.repositoryPath);
        commandRequest.setPrintInConsole(gitRequest.isPrintInConsole);
        commandRequest.cmdOutputLineCallBack = gitRequest.cmdOutputLineCallBack;
        CommandResponse commandResponse = osCommandExec.execute(commandRequest);
        if (!commandResponse.isExecuted){
            throw new GitCommandException(commandResponse.exceptionMessage);
        }
        return commandResponse;
    }

    private CommandResponse executeSingle(String command) throws GitCommandException {
        return execute(gitRequest.appPath, command);
    }


    public Boolean pull() throws GitCommandException {
        return executeSingle("pull").isExecuted;
    }

    public Boolean fetchAll() throws GitCommandException {
        return execute(gitRequest.appPath, "fetch", "--all").isExecuted;
    }

    public void reset(){

    }

    public Boolean checkout(String branchName) throws GitCommandException {
        return execute(gitRequest.appPath, "checkout", branchName).isExecuted;
    }

    public String branch() throws GitCommandException {
        return executeSingle("branch").commandOutput;
    }

    public CommandResponse remoteBranch() throws GitCommandException {
       return execute(gitRequest.appPath, "branch", "-r");
    }

    public void clean(){}

    public void gitClone(){}

    public void diff(){}


    public String diffBetweenFileNameOnly(String from, String to) throws GitCommandException {
        return execute(gitRequest.appPath, "diff", "--name-only", from, to).commandOutput;
    }

    public String diffBetweenFileNameOnly() throws GitCommandException {
        return execute(gitRequest.appPath, "diff", "--name-only").commandOutput;
    }


    public String lastCommitHash() throws GitCommandException {
        return execute(gitRequest.appPath, "log", "-l", "--format=%H").commandOutput;
    }

}
