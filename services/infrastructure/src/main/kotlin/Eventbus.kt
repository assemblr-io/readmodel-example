package infrastructure

import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.*
import kotlin.coroutines.coroutineContext
import event.Event
class EventBus {
    private val _events = MutableSharedFlow<Event>()
    val events = _events.asSharedFlow()

    suspend fun emitEventList(events: List<Event>){
        events.forEach{event->
            _events.emit(event)
        }
    }

    suspend inline fun <reified T> subscribe(crossinline onEvent: (T) -> Unit) {
        events.filterIsInstance<T>()
            .collectLatest { event ->
                coroutineContext.ensureActive()
                onEvent(event)
            }
    }
}
