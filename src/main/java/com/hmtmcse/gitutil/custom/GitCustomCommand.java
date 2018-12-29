package com.hmtmcse.gitutil.custom;

import com.hmtmcse.gitutil.base.GitCommand;
import com.hmtmcse.gitutil.base.GitCommandException;
import com.hmtmcse.gitutil.base.GitRequest;
import com.hmtmcse.shellutil.base.CommandResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GitCustomCommand extends GitCommand {


    public GitCustomCommand(GitRequest gitRequest) throws GitCommandException {
        super(gitRequest);
    }


    public GitBranchListResponse getProcessedAllBrances() throws GitCommandException {
        CommandResponse commandResponse = remoteBranch();
        GitBranchListResponse gitBranchListResponse = new GitBranchListResponse();
        List<String> list = new ArrayList<>();
        if (commandResponse.commandOutput != null){
            String[] lines = commandResponse.commandOutput.split("\\r?\\n");
            String branch, name;
            for (String line : lines) {
                branch = line;
                if (!branch.contains("->")) {
                    name = branch.replace("origin/", "");
                    list.add(name.trim());
                }
            }
        }
        gitBranchListResponse.setBranches(list);
        gitBranchListResponse.setSelected(selectedBranch());
        gitBranchListResponse.setLastCommit(lastCommitHash());
        return gitBranchListResponse;
    }


    public String selectedBranch() throws GitCommandException {
        String allLocalBranches = branch();
        if (allLocalBranches != null){
            Pattern pattern = Pattern.compile("(\\*\\s+[\\w+\\.]+)");
            Matcher matcher = pattern.matcher(allLocalBranches);
            if (matcher.find() && matcher.group(0) != null){
               return matcher.group(0).replace("*","").trim();
            }
        }
        return null;
    }



}
