// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String) {
    override fun toString(): String {
        return "${this.nome} - ${this.email}"
    }
}

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60) {
    override fun toString(): String {
        return "${this.nome} - ${this.nivel} - ${this.duracao}"
    }
}

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun imprimirInscritos(){
        for(usuario in inscritos){
            println(usuario)
        }
    }
    
    fun imprimirConteudos(){
        for(conteudo in conteudos){
            println(conteudo)
        }
    }
    
    private fun formatarConteudosParaImpressao(): String {
        var str = ""
        for(conteudo in conteudos){
            str += conteudo
            str += "\n"
        }
        return str
    }
    
    private fun formatarUsuariosParaImpressao(): String {
    	var str = ""
        for(usuario in inscritos){
            str += usuario
            str += "\n"
        }
        return str
    }
    
    override fun toString(): String {
        var str = "############## FORMAÇÃO ##############\n"
        str += "Nome: ${this.nome}\n"
        str += "Nível: ${this.nivel}\n"
        str += "############## CONTEÚDOS ##############\n"
      	str += formatarConteudosParaImpressao()
        str += "############## USUÁRIOS INSCRITOS ##############\n"
        str += formatarUsuariosParaImpressao()
        return str
    }
}

fun main() {
    val conteudosEducacionaisJava: List<ConteudoEducacional> = 
    	listOf(ConteudoEducacional("Pricipais Protocolos de Comunicação da Internet", Nivel.BASICO, 180),
               ConteudoEducacional("Imersão no Spring Framework com Spring Boot", Nivel.INTERMEDIARIO, 180),
               ConteudoEducacional("Explorando Padrões de Projeto na Prática com Java", Nivel.AVANCADO, 120))
        
    val formacaoJavaDeveloper: Formacao = Formacao("Formação Java Developer", Nivel.INTERMEDIARIO, conteudosEducacionaisJava)
        
    val usuarios: List<Usuario> = listOf(Usuario("Denilson", "denilson@gmail.com"),
                                         Usuario("Julia", "julia@gmail.com"),
                                         Usuario("Marisa", "marisa@gmail.com"))
    for(usuario in usuarios){
        formacaoJavaDeveloper.matricular(usuario)
    }
    
    print(formacaoJavaDeveloper)
}