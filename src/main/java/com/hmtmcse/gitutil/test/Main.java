package com.hmtmcse.gitutil.test;

import com.hmtmcse.gitutil.base.GitCommand;
import com.hmtmcse.gitutil.base.GitCommandException;
import com.hmtmcse.gitutil.base.GitRequest;

public class Main {

    public static void main(String[] args) {
        try {
            GitCommand gitCommand = new GitCommand(GitRequest.instance("C:\\Program Files\\Git\\cmd\\git.exe", "W:\\opensource\\task-manager").setPrintInConsole(true));
            gitCommand.remoteBranch();
            gitCommand.branch();
            gitCommand.fetchAll();
            gitCommand.pull();
        } catch (GitCommandException e) {
            System.out.println(e.getMessage());
        }
    }

}
