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
     * Deletes the user identified by the given ID.
     *
     * @param userId ID of the user to delete
     * @throws UserNotFoundException if no user with this ID exists
     */
    void deleteUser(Long userId);

    /**
     * Replaces all fields of the user identified by {@code userId} with the data from {@code userDto}.
     *
     * @param userId  ID of the user to update
     * @param userDto new field values
     * @return the updated user
     * @throws UserNotFoundException if no user with this ID exists
     */
    User updateUser(Long userId, UserDto userDto);

}