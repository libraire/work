package party.msdg.work.base.work;

/**
 * <h1>编码规范 <code>1 2 3 4 5 6</code></h1>
 * <p>
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
public record WorkCode(int code, String text) {
    
    /**
     * 默认异常
     */
    public static WorkCode DEF = new WorkCode(100000, "业务异常");
    
    public static WorkCode UNLOGIN = new WorkCode(111001, "需要登录后访问");
    
    public static final WorkCode DB_SOURCE_NOT_FOUND = new WorkCode(112001, "数据未找到。");
}
