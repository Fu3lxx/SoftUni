package softuni.exam.instagraphlite.models.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "pictures")
public class Picture extends BaseEntity {

    private String path;
    private double size;
    private Set<User> users;
    private Set<Post> posts;

    @OneToMany (mappedBy = "picture")
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @OneToMany (mappedBy = "profilePicture")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column (name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column (name = "size")
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
