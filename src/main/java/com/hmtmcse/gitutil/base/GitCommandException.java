package com.hmtmcse.gitutil.base;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class GitCommandException extends Exception {

    public GitCommandException(){
        super("Git Command Exception Occurred!");
    }

    public GitCommandException(String message){
        super(message);
    }
}
