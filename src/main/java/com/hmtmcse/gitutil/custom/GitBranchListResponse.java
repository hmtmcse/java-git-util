package com.hmtmcse.gitutil.custom;

import java.util.List;

/**
 * Created by Touhid Mia on 14/02/2016.
 */

public class GitBranchListResponse {

    public String selected;
    public String lastCommit;
    public List<String> branches;



    public String getLastCommit() {
        return lastCommit;
    }

    public void setLastCommit(String lastCommit) {
        this.lastCommit = lastCommit;
    }

    public List<String> getBranches() {
        return branches;
    }

    public void setBranches(List<String> branches) {
        this.branches = branches;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }



}
