package pl.wsb.fitnesstracker.user.api;

/**
 * User data transfer object used for email-based search results.
 *
 * @param id    unique identifier of the user
 * @param email user's email address
 */
public record UserEmailDto(Long id, String email) {

}
