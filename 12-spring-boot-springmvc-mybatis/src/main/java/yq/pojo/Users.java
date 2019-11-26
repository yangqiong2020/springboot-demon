package yq.pojo;

public class Users {
    private Integer userid;
    private Integer userage;
    private String username;

    public Users(Integer userid, Integer userage, String username) {
        this.userid = userid;
        this.userage = userage;
        this.username = username;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", userage=" + userage +
                ", username='" + username + '\'' +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
