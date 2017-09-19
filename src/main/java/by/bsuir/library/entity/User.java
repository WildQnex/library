package by.bsuir.library.entity;

import by.bsuir.library.util.IdGenerator;

import java.io.Serializable;

public class User implements Serializable{
    private long id;
    private long activation;
    private String name;
    private String mail;
    private String passHash;
    private Role role;


    public User(String name, String username, String passHash, Role role, long activation) {
        this.id = IdGenerator.getInstance().nextUserId();
        this.name = name;
        this.mail = username;
        this.passHash = passHash;
        this.role = role;
        this.activation = activation;
    }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean activateUser(long code){
        if(code == activation || activation == 0){
            activation = 0;
            return true;
        }else {
            return false;
        }
    }

    public boolean isActvated(){
        return this.activation == 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (activation != user.activation) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (passHash != null ? !passHash.equals(user.passHash) : user.passHash != null) return false;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (activation ^ (activation >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (passHash != null ? passHash.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", activation=" + activation +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", passHash='" + passHash + '\'' +
                ", role=" + role +
                '}';
    }
}

