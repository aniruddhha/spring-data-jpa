package com.ani.orm.ormdetails.mapping;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingService {

    private final BoardRepository boardRepository;
    private final ChipRepository chipRepository;
    private final ProcessorRepository processorRepository;

    public MappingService(
            BoardRepository boardRepository,
            ChipRepository chipRepository,
            ProcessorRepository processorRepository
    ) {
        this.boardRepository = boardRepository;
        this.chipRepository = chipRepository;
        this.processorRepository = processorRepository;
    }

    public void createSingleBoard() {
        Board board = new Board();
        board.setMfg("abc");
        board.setMfgDt(LocalDate.now());
        boardRepository.save(board);
    }

    public void createSingleChip() {
        Chip chip = new Chip();
        chip.setPrg(true);
        chip.setCompatibility("single");

        Board board = boardRepository.findById(1L).orElseThrow(RuntimeException::new);
        chip.setBoard(board);
        chipRepository.save(chip);
    }

    public void createBoardWithChips() {
        Board board = new Board();
        board.setBrdId(2L);
        board.setMfg("pqr");
        board.setMfgDt(LocalDate.now());

        List<Chip> chips = new ArrayList<>();
        Chip chip1 = new Chip();
        chip1.setPrg(false);
        chip1.setCompatibility("single-1");
        chip1.setBoard(board);
        chips.add(chip1);

        Chip chip2 = new Chip();
        chip2.setPrg(true);
        chip2.setCompatibility("single-2");
        chip2.setBoard(board);
        chips.add(chip2);

        board.setChips(chips);

        boardRepository.save(board);
    }

    @Transactional
    public void findAllChipsByBoardId() {
        Board board = boardRepository.findById(1L).orElseThrow(RuntimeException::new);
        board.getChips().forEach(System.out::println);
    }

    public void findAllChips() {
        chipRepository.findAll().forEach(System.out::println);
    }

    @Transactional
    public void saveProcessor() {

        Board board = boardRepository.findById(2L).orElseThrow(RuntimeException::new);

        Processor processor = new Processor();
        processor.setMake("jkl");
        processor.setType(1);
        processor.setBoard(board);

        processorRepository.save(processor);
    }

    public void findAllProcessors() {
        processorRepository.findAll().forEach(System.out::println);
    }

    @Transactional
    public void findAllProcessorsByBoardId() {
        processorRepository.findAll().stream()
                .filter( pr -> pr.getBoard().getBrdId() == 2L )
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


    public void chipOnBoardFetch() {
        chipRepository.chipOnBoard(1L).orElseThrow(RuntimeException::new).forEach(System.out::println);
    }
}
