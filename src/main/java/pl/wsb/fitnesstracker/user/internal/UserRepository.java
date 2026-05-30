package pl.wsb.fitnesstracker.user.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Query searching users by email address. It matches by exact match.
     *
     * @param email email of the user to search
     * @return {@link Optional} containing found user or {@link Optional#empty()} if none matched
     */
    default Optional<User> findByEmail(String email) {
        return findAll().stream()
                .filter(user -> Objects.equals(user.getEmail(), email))
                .findFirst();
    }

    /**
     * Returns all users whose e-mail contains {@code fragment} (case-insensitive).
     *
     * @param fragment substring to search for
     * @return matching users
     */
    List<User> findByEmailContainingIgnoreCase(String fragment);

    /**
     * Returns all users born strictly before {@code date}.
     *
     * @param date upper-exclusive birthdate boundary
     * @return users older than the given date implies
     */
    List<User> findByBirthdateBefore(LocalDate date);

}