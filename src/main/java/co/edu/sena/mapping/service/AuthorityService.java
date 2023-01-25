package co.edu.sena.mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.sena.mapping.domain.Authority;
import co.edu.sena.mapping.repository.AuthorityRepository;

@Service
public abstract class AuthorityService implements AuthorityRepository {

//	@Autowired
//	AuthorityRepository authorityRepository;
//
//	@Override
//	@Transactional(readOnly = true)
//	public Optional<Authority> findById(String id) {
//		return authorityRepository.findById(id);
//	}
//
//	@Override
//	public void deleteById(String id) {
//		authorityRepository.deleteById(id);
//	}
//
//	@Override
//	public Authority findByName(String name) {
//		return authorityRepository.findByName(name);
//	}
//
//	@Override
//	public List<Authority> findAll() {
//		return authorityRepository.findAll();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public Authority save(Authority authority) {
//		return authorityRepository.save(authority);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public Iterable<Authority> saveAll(Iterable listA) {
//		return authorityRepository.saveAll(listA);
//	}
//
//	@Override
//	public int updateAuthority(String name, String name2) {
//		return authorityRepository.updateAuthority(name, name2);
//	}
//
//	@Override
//	public void deleteByName(String name) {
//		authorityRepository.deleteByName(name);
//	}
//
//	@Override
//	public void deleteAll() {
//		authorityRepository.deleteAll();
//	}

}
