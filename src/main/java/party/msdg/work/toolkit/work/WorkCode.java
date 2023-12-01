package party.msdg.work.toolkit.work;

/**
 * <h1>编码规范 <code>1 2 3 4 5 6</code></h1>
 *
 * <br/>
 * <pre>
 *     1 2 大模块编号
 *     3 4 功能编号
 *     5 6 具体异常类型
 * </pre>
 * <pre>
 *    🐛  0~20 保留位
 *    🌟 21~99 自定义位
 * </pre>
 * Wow! Sweet moon.🌕
 */
public class WorkCode {
    
    /**
     * 默认异常
     */
    public static WorkCode DEF = new WorkCode(100000, "业务异常");
    
    private final int code;
    private final String text;
    
    public WorkCode(int code, String text) {
        this.code = code;
        this.text = text;
    }
    
    public int code() {
        return code;
    }
    
    public String text() {
        return text;
    }
}
