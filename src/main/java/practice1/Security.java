package practice1;

import com.google.common.collect.ImmutableList;

public class Security {

    private SecurityChecker securityChecker;

    public Security(SecurityChecker checker) {
        this.securityChecker = checker;
    }

    boolean getFalseAccecc(User user,Permission permission,ImmutableList<Permission> permissions){
        return (user == null||permission==null||permissions.size()==0);
    }

    boolean getTrueAccecc(User user,Permission permission,ImmutableList<Permission> permissions){
        return (this.securityChecker.checkPermission(user, permission) || permissions.contains(permission)||securityChecker.isAdmin());
    }

    public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {
        if (getFalseAccecc(user,permission,permissions)) return false;
        if (getTrueAccecc(user,permission,permissions)) return true;
        return false;
    }
}
