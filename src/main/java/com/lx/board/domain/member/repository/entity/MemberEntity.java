package com.lx.board.domain.member.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity(name = "MEMBER")
@Getter
@NoArgsConstructor
public class MemberEntity {

        @GeneratedValue(generator = "memberIdGenerator")
        @GenericGenerator(name = "uuid2", type = org.hibernate.id.uuid.UuidGenerator.class)
        @Id
        private UUID Id;
        @Column
        private String username;
        @Column
        private String password;
        @Column
        private String nickname;

        public MemberEntity(String username, String password, String nickname) {
                this.username = username;
                this.password = password;
                this.nickname = nickname;
        }

        public void update(String username, String password, String nickname) {
                this.username = username;
                this.password = password;
                this.nickname = nickname;
        }
}
