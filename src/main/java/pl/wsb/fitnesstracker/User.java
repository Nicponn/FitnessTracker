package pl.wsb.fitnesstracker;
import java.time.LocalDate;

    @Entity
    @Table(name = "Users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "firstName", nullable = false)
        private String firstName;

        @Column(name = "lastName", nullable = false)
        private String lastName;

        @Column(name = "birthday")
        private LocalDate birthday;

        @Column(name = "email", nullable = false, unique = true)
        private String email;


        public User() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDate birthday) {
            this.birthday = birthday;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

