@Entity
public class TransactionLog {
    @Id @GeneratedValue
    private Long id;

    private Double amount;
    private LocalDate date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;
}