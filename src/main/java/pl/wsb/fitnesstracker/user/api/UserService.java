package pl.wsb.fitnesstracker.user.api;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {

    /**
     * Creates a new user.
     *
     * @param user The user to be created
     * @return The created user
     */
    User createUser(User user);

    /**
     * Updates an existing user identified by the given ID.
     *
     * @param userId      identifier of the user to update
     * @param updatedUser user data to apply
     * @return the updated user
     */
    User updateUser(Long userId, User updatedUser);

    /**
     * Deletes a user identified by the given ID.
     *
     * @param userId identifier of the user to delete
     */
    void deleteUser(Long userId);

}
