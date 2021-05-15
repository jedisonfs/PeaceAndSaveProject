package co.edu.sena.mapping.web.rest;

public class RegionalResource {

//	RegionalRepository regionalRepository;
//
//	@GetMapping("/regional/{codeRegional}")
//	public ResponseEntity<Regional> getRegional(@PathVariable int codeRegional) {
//		Regional regional = regionalRepository.findByRegionalCode(codeRegional);
//		return ResponseEntity.ok().body(regional);
//	}
//
//	@GetMapping("/regional")
//	public ResponseEntity<List<Regional>> getAllRegional() {
//		List regionals = (List) regionalRepository.findAll();
//		return ResponseEntity.ok().body(regionals);
//	}
//
//	@PostMapping("/regional")
//	public ResponseEntity<Regional> insertRegional(@Valid @RequestBody Regional regional, Model model) {
//		regionalRepository.save(regional);
//		return ResponseEntity.ok().body(regional);
//	}
//
//	@PostMapping("/regional/all")
//	public ResponseEntity<List<Regional>> insertAllRegional(@Valid @RequestBody List<Regional> listRegional) {
//		regionalRepository.saveAll(listRegional);
//		return ResponseEntity.ok().body(listRegional);
//	}
//
//	@PutMapping("/regional")
//	public ResponseEntity<Regional> updateRegional(@Valid @RequestBody Regional regional) {
//		regional = regionalRepository.findByRegionalCode(regional.getId());
//		regionalRepository.save(regional);
//		return ResponseEntity.ok().body(regional);
//	}
//
//	@ResponseStatus(HttpStatus.OK)
//	@DeleteMapping("/regional/{codeRegional}")
//	public void deleteByCodeRegional(@PathVariable int codeRegional) {
//		regionalRepository.deleteByRegionalCode(codeRegional);
//	}
}
