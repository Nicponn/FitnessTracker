package pl.wsb.fitnesstracker.user.api;

/**
 * Simplified user data transfer object containing only basic identification fields.
 *
 * @param id        unique identifier of the user
 * @param firstName user's first name
 * @param lastName  user's last name
 */
public record SimpleUserDto(Long id, String firstName, String lastName) {

}
