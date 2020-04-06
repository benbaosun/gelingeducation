package com.project.gelingeducation.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", length = 24)
    private String name;

    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "remark")
    private String remark;

    @Column(name = "url")
    private String url;

    /**
     * 权限标识
     */
    @Column(name = "perms",length = 12)
    private String perms;

    @ManyToMany(targetEntity = Role.class)
    @JsonIgnoreProperties(value = "permissions")
    @JoinTable(
            name = "t_role_permission",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

}
