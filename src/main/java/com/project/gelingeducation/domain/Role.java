package com.project.gelingeducation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 9205096691157148000L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 24, nullable = false)
    private String name;

    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "remark")
    private String remark;
    //0为不是默认注册时的身份,1为默认
    @Column(name = "is_default")
    private int isDefault = 0;

    //    @ManyToMany(targetEntity = User.class)
//    @JoinTable(
//            name = "t_user_role",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
    @OneToMany(targetEntity = User.class, mappedBy = "role")
    @JsonIgnore
    private Set<User> users = new HashSet<>();


    @ManyToMany(targetEntity = Permission.class, mappedBy = "roles")
    @JsonIgnore
    private Set<Permission> permissions = new HashSet<>();

}
