package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Movie;

public interface IService <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
