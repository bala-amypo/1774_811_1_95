@Entity
public class BudgetPlan {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;
}