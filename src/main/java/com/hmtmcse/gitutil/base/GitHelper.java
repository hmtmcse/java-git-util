package com.hmtmcse.gitutil.base;

import com.hmtmcse.shellutil.print.ConsolePrinter;

public class GitHelper {


    public static void main(String[] args) {

        GitRequest gitRequest = new GitRequest();
        gitRequest.appPath = "C:\\Program Files\\Git\\bin\\git.exe";
        gitRequest.repositoryPath = "J:\\git\\exp";
        gitRequest.isPrintInConsole = true;
        gitRequest.isPrintCommands = true;

        try {
            GitCommand gitCommand = new GitCommand(gitRequest);
            String output = gitCommand.lastCommitHash();
            ConsolePrinter.printLine(output);
        } catch (GitCommandException e) {
            e.printStackTrace();
        }
    }

}
