package by.bsuir.library.entity;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private String username;
    private String passHash;
    private int privilege;

    public User(String name, String username, String passHash, int privilege) {
        this.name = name;
        this.username = username;
        this.passHash = passHash;
        this.privilege = privilege;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassHash() {
        return passHash;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (privilege != user.privilege) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return passHash != null ? passHash.equals(user.passHash) : user.passHash == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passHash != null ? passHash.hashCode() : 0);
        result = 31 * result + privilege;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", passHash='" + passHash + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}

