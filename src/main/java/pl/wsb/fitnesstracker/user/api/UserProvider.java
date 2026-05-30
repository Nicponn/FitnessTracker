package pl.wsb.fitnesstracker.user.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserProvider {

    /**
     * Retrieves a user based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be returned.
     *
     * @param userId id of the user to be searched
     * @return An {@link Optional} containing the located user, or {@link Optional#empty()} if not found
     */
    Optional<User> getUser(Long userId);

    /**
     * Retrieves a user based on their email.
     * If the user with given email is not found, then {@link Optional#empty()} will be returned.
     *
     * @param email The email of the user to be searched
     * @return An {@link Optional} containing the located user, or {@link Optional#empty()} if not found
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Retrieves all users.
     *
     * @return list of all users stored in the system
     */
    List<User> findAllUsers();

    /**
     * Searches users whose email contains the given fragment, ignoring case.
     *
     * @param emailFragment fragment of the email address to search for
     * @return list of matching users
     */
    List<User> findUsersByEmailFragment(String emailFragment);

    /**
     * Retrieves users born before the given date.
     *
     * @param date reference date; users older than this date are returned
     * @return list of users older than the given date
     */
    List<User> findUsersOlderThan(LocalDate date);

}
