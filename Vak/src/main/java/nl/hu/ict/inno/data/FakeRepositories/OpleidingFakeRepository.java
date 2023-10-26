package nl.hu.ict.inno.data.FakeRepositories;

import nl.hu.ict.inno.domain.Opleiding;

import java.util.List;

public interface OpleidingFakeRepository {

    Opleiding findById(Long id);
    List<Opleiding> findAll();
}
