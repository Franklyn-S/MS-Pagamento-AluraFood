package br.com.alurafood.pagamentos.controller;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService service;

	@GetMapping
	public Page<PagamentoDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.obterTodos(paginacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PagamentoDto> detalhar(@PathVariable @NotNull Long id) {
		PagamentoDto dto = service.obterPorId(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<PagamentoDto> cadastrar(
			@RequestBody @Valid PagamentoDto dto,
			UriComponentsBuilder uriBuilder
	) {
		PagamentoDto pagamento = service.criarPagamento(dto);
		URI endereco = uriBuilder.path("/pagamento/{id}").buildAndExpand(pagamento.getId()).toUri();
		return ResponseEntity.created(endereco).body(pagamento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PagamentoDto> atualizar(
			@PathVariable @NotNull Long id,
			@RequestBody @Valid PagamentoDto dto
	) {
		PagamentoDto pagamentoAtualizado = service.atualizarPagamento(id, dto);
		return ResponseEntity.ok(pagamentoAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable @NotNull Long id) {
		service.deletarPagamento(id);
		return ResponseEntity.noContent().build();
	}

}
