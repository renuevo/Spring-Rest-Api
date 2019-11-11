# Rest API



#### 1) Uniform (유니폼 인터페이스)

Uniform Interface Constraints는 REST Design에서 가장 기본적인 제약이지만, 현재 대부분의 REST API라고 부르는 API에서 지켜지지 않는 제약입니다

개발하고자하는 Architecture를 간단히 하고 Client와 Server를 분리하여 각각 독립적으로 진화하여 전개될 수 있게 합니다

즉, 통일된 Interface를 통해, 어떠한 기술(Phython, PHP, C#, Ruby, Java)이든 어떠한 Platform(iOS, Android, Mac, Windows)이든 상관없이 사용할 수 있습니다



> 1. Resouce Indentifier (URI)
> 2. Resource Representations
> 3. Self-Descriptive Message
> 4. HASTOEAS (Hypermedia As The Engine Of Application State)



**Resouce Indentifier (URI)**

> Resource는 하나 이상의 유일한 특정 주소인 URI를 반드시 소유해야 합니다
>
> 일반적으로 명사형으로 URI를 정의하도록 권장하고 있으며 WEB상에서 URL을 통해 제한된 Method에 접근할 수 있습니다
>
> Rest에서의 Recource는 주요 Type으로 Collections이나 Items으로 정의되기를 권장합니다
>
> 또한 URL은 URI의 Network location에 대한 정보를 가지는 Path이고 URI는 Client와 Server간의 Resource의 Representation을 교환하기 위한 변하지 않는 주소 정보를 포함한 Identifier(식별자) 입니다



**Resource Representation**

> Client-Server 구조에서 Resouce를 직접 주고 받는 것이 아니라, 그 Resource에 대한 상태나 정보를 설명(대표)하는 Representation을 주고 받습니다
>
> Resource는 하나 이사으이 Representation을 가질 수 있으며 content-type으로 형태가 결정됩니다
>
> - Representation Formats
>   - text/html
>   - application/xml
>   - application/json
>   - application/x-www-form-urlencoded (for input: PUT,POST)
>   - Others : image(svg,jpg,png,etc.), txt/css, text/javascript



**Self-Descriptive Message**

> REST는 Stateless하며 이는 Client-Server간의 Message에서 자신을 충분히 설명 가능한 정보를 가지고 있어야 합니다
>
> Request와 Response를 이해하는데 충분한 정보와 HTTP의 status code등을 활용하여 정보도 전달합니다
>
> 한 예로 HTML은 media type이 text/html임을 보고 [HTML 명세 정의](https://www.w3.org/TR/html52/)로 명세를 확인 할 수 있습니다



#### 2) Stateless (무상태성)

Rest API는 작업을 위한 상태정보를 따로 저장하고 관리하지 않는 Stateless 성격을 갖습니다 

단순히 요청에 대한 결과만을 처리 하므로써 서비스의 자유도가 높아지고 로드밸런싱과 같은 유연한 아키텍처 적용도 가능합니다



#### 3) Cacheable (캐시 가능)

REST의 가장 큰 특징 중 하나는 HTTP라는 기존 웹표준을 그대로 사용하기 때문에, 웹에서 사용하는 기존 인프라를 그대로 활용이 가능합니다

따라서 HTTP가 가진 캐싱 기능이 적용 가능합니다

보통 Web Service의 60~80%의 Transcation이 조회인것을 감안하면 Cache기능은 큰 장점입니다

HTTP 프로토콜 표준에서 사용하는 Last-Modified태그나 E-Tag를 이용하면 캐싱 구현이 가능합니다



#### 4) Layered System

REST 서버는 다중 계층으로 구성될 수 있으며 보안, 로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있고 PROXY, 게이트웨이 같은 네트워크 기반의 중간매체를 사용할 수 있게 합니다



#### 5) Client - Server

Client와 Server를 서로 분리 함으로써 서로의 역할이 명확해지고 서로간 의존성을 줄어들게 분리 하는 것입니다Rest Server는 Resource를 관리하는 API를 제공하고, Client 는 사용자 인증이나 Session, Login 정보등을 직접 관리므로 서로간의 의존관계를 생각하지 않고 각각의 기능에 집중할 수 있어 보다 쉽게 확장이 가능해 진다



#### 6) Code On Demand (optional)







------


