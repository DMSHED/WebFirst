package com.http.dto;

import jakarta.servlet.http.Part;

public final class CreateUserDto {
    private final String name;
    private final String birthday;
    private final Part Image;
    private final String email;
    private final String password;
    private final String role;
    private final String gender;

    CreateUserDto(String name, String birthday, Part Image, String email, String password, String role, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.Image = Image;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public static CreateUserDtoBuilder builder() {
        return new CreateUserDtoBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public Part getImage() {
        return this.Image;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }

    public String getGender() {
        return this.gender;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CreateUserDto)) return false;
        final CreateUserDto other = (CreateUserDto) o;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$birthday = this.getBirthday();
        final Object other$birthday = other.getBirthday();
        if (this$birthday == null ? other$birthday != null : !this$birthday.equals(other$birthday)) return false;
        final Object this$Image = this.getImage();
        final Object other$Image = other.getImage();
        if (this$Image == null ? other$Image != null : !this$Image.equals(other$Image)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $birthday = this.getBirthday();
        result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
        final Object $Image = this.getImage();
        result = result * PRIME + ($Image == null ? 43 : $Image.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        return result;
    }

    public String toString() {
        return "CreateUserDto(name=" + this.getName() + ", birthday=" + this.getBirthday() + ", Image=" + this.getImage() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", role=" + this.getRole() + ", gender=" + this.getGender() + ")";
    }

    public static class CreateUserDtoBuilder {
        private String name;
        private String birthday;
        private Part Image;
        private String email;
        private String password;
        private String role;
        private String gender;

        CreateUserDtoBuilder() {
        }

        public CreateUserDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CreateUserDtoBuilder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public CreateUserDtoBuilder Image(Part Image) {
            this.Image = Image;
            return this;
        }

        public CreateUserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CreateUserDtoBuilder password(String password) {
            this.password = password;
            return this;
        }

        public CreateUserDtoBuilder role(String role) {
            this.role = role;
            return this;
        }

        public CreateUserDtoBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public CreateUserDto build() {
            return new CreateUserDto(this.name, this.birthday, this.Image, this.email, this.password, this.role, this.gender);
        }

        public String toString() {
            return "CreateUserDto.CreateUserDtoBuilder(name=" + this.name + ", birthday=" + this.birthday + ", Image=" + this.Image + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ", gender=" + this.gender + ")";
        }
    }
}
